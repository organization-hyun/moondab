import 'package:adv_basics/question_screen.dart';
import 'package:adv_basics/screens/auth.dart';
import 'package:adv_basics/start_screen.dart';
import 'package:flutter/material.dart';

class Quiz extends StatefulWidget {
  const Quiz({super.key});

  @override
  State<Quiz> createState() {
    return _QuizState();
  }
}

class _QuizState extends State<Quiz> {
  var activeScreen = 'start-screen';

  void switchScreen() {
    setState(() {
      activeScreen = 'questions-screen';
    });
  }

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: AuthScreen(),

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
