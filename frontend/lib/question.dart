import 'package:moondab/data/question_repository.dart';
import 'package:moondab/screens/question_screen.dart';
import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:moondab/screens/auth.dart';

import 'package:moondab/screens/splash.dart';

class Question extends StatefulWidget {
  const Question({super.key});

  @override
  State<Question> createState() {
    return _QuestionState();
  }
}

class _QuestionState extends State<Question> {
  var activeScreen = 'start-screen';

  void switchScreen() {
    setState(() {
      activeScreen = 'questions-screen';
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: StreamBuilder(
            stream: FirebaseAuth.instance.authStateChanges(),
            builder: (ctx, snapshot) {
              if (snapshot.connectionState == ConnectionState.waiting) {
                return const SplashScreen();
              }

              if (snapshot.hasData) {
                return QuestionScreen(
                  questionRepository: DummyQuestionRepositoryImpl(),
                );
              }

              return const AuthScreen();
            })

        // Scaffold(
        //   body: Container(
        //       decoration: const BoxDecoration(
        //         gradient: LinearGradient(
        //           colors: [
        //             Color.fromARGB(255, 98, 51, 180),
        //             Color.fromARGB(255, 83, 29, 176),
        //           ],
        //           begin: Alignment.topLeft,
        //           end: Alignment.bottomRight,
        //         ),
        //       ),
        //       child: activeScreen == 'start-screen'
        //           ? StartScreen(switchScreen)
        //           : const QuestionScreen()),
        // ),
        );
  }
}
