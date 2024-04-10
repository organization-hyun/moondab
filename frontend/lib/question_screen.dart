import 'package:adv_basics/data/questions_data.dart';
import 'package:adv_basics/widgets/date_picker.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class QuestionScreen extends StatefulWidget {
  const QuestionScreen({
    super.key,
    required this.onAnswer,
  });

  final void Function() onAnswer;

  @override
  State<QuestionScreen> createState() {
    return _QuestionScreen();
  }
}

class _QuestionScreen extends State<QuestionScreen> {
  var currentQuestionIndex = 0;

  void answerQuestion(String answer) {
    setState(() {
      widget.onAnswer();
      currentQuestionIndex++;
    });
  }

  String getTodayInfo() {
    DateTime now = DateTime.now();
    DateFormat formatter = DateFormat('MM/dd');
    return formatter.format(now);
  }

  DateTime _selectedDate = DateTime.now();

  void _onDateChanged(DateTime newDate) {
    setState(() {
      _selectedDate = newDate;
    });
  }

  @override
  Widget build(context) {
    final currentQuestion = questions[currentQuestionIndex];
    return Scaffold(
      appBar: AppBar(
        title: GestureDetector(
          onTap: () {
            showModalBottomSheet(
              context: context,
              builder: (BuildContext context) {
                return MonthDayPicker(
                  initialDate: _selectedDate,
                  onDateChanged: _onDateChanged,
                );
              },
            );
          },
          // child: Text(getTodayInfo()),
          child: Text(
            DateFormat('MM/dd').format(_selectedDate),
          ),
        ),
        actions: [
          IconButton(
            onPressed: () {
              FirebaseAuth.instance.signOut();
            },
            icon: Icon(
              Icons.exit_to_app,
              color: Theme.of(context).colorScheme.primary,
            ),
          ),
        ],
      ),
      body: SizedBox(
        width: double.infinity,
        child: Container(
          margin: const EdgeInsets.all(40),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              Text(
                currentQuestion.text,
                textAlign: TextAlign.center,
                style: const TextStyle(color: Colors.black),
              ),
              OutlinedButton(
                  onPressed: () {
                    setState(() {
                      if (currentQuestionIndex != 0) {
                        currentQuestionIndex -= 1;
                      }
                    });
                  },
                  child: const Text('이전')),
              OutlinedButton(
                  onPressed: () {
                    setState(() {
                      if (currentQuestionIndex < questions.length - 1) {
                        currentQuestionIndex += 1;
                      }
                    });
                  },
                  child: const Text('다음')),
            ],
          ),
        ),
      ),
    );
  }
}
