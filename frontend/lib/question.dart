import 'package:adv_basics/data/question_repository.dart';
import 'package:adv_basics/screens/question_screen.dart';
import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:adv_basics/screens/auth.dart';

import 'package:adv_basics/screens/splash.dart';

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
              // return const Groups();
            }

            return const AuthScreen();
          }),
    );
  }
}
