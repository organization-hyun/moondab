import 'package:adv_basics/data/question_repository.dart';
import 'package:adv_basics/models/questions.dart';
import 'package:adv_basics/widgets/date_picker.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class QuestionScreen extends StatefulWidget {
  final void Function() onAnswer;
  final QuestionRepository questionRepository;

  const QuestionScreen({
    super.key,
    required this.onAnswer,
    required this.questionRepository,
  });

  @override
  State<QuestionScreen> createState() {
    return _QuestionScreen();
  }
}

class _QuestionScreen extends State<QuestionScreen> {
  var currentQuestionIndex = 0;
  late Question currentQuestion;

  @override
  void initState() {
    super.initState();
    _loadQuestion();
  }

  void _loadQuestion() {
    final now = DateTime.now();
    final question = widget.questionRepository.getQuestionByMonthDay(
      month: now.month,
      day: now.day,
    );
    setState(() {
      currentQuestion = question;
    });
  }

  //todo: 삭제?
  // void answerQuestion(String answer) {
  //   setState(() {
  //     widget.onAnswer();
  //     currentQuestionIndex++;
  //   });
  // }

  // String getTodayInfo() {
  //   DateTime now = DateTime.now();
  //   DateFormat formatter = DateFormat('MM/dd');
  //   return formatter.format(now);
  // }

  DateTime _selectedDate = DateTime.now();

  void _onDateChanged(DateTime newDate) {
    setState(() {
      _selectedDate = newDate;
      _syncQuestionAndDate(
        currentQuestion,
        _selectedDate,
      );
    });
  }

  void _syncQuestionAndDate(Question currentQuestion, DateTime currentDate) {
    setState(() {
      this.currentQuestion = widget.questionRepository.getQuestionByMonthDay(
        month: currentDate.month.toInt(),
        day: currentDate.day.toInt(),
      );
    });
  }

  @override
  Widget build(context) {
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
              const TextField(
                  decoration: InputDecoration(
                border: OutlineInputBorder(),
                labelText: '답변',
              )),
              OutlinedButton(onPressed: () {}, child: const Text('제출')),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  OutlinedButton(
                      onPressed: () {
                        setState(() {
                          _selectedDate =
                              _selectedDate.add(const Duration(days: -1));
                          _syncQuestionAndDate(currentQuestion, _selectedDate);
                        });
                      },
                      child: const Text('이전')),
                  OutlinedButton(
                      onPressed: () {
                        setState(() {
                          _selectedDate =
                              _selectedDate.add(const Duration(days: 1));
                          _syncQuestionAndDate(currentQuestion, _selectedDate);
                        });
                      },
                      child: const Text('다음')),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}
