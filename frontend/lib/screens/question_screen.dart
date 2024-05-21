import 'package:moondab/data/question_repository.dart';
import 'package:moondab/data/questions_data.dart';
import 'package:moondab/models/answer.dart';
import 'package:moondab/models/answer_database.dart';
import 'package:moondab/models/questions.dart';
import 'package:moondab/screens/group_screen.dart';
import 'package:moondab/screens/profile_screen.dart';
import 'package:moondab/widgets/date_picker.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';

class QuestionScreen extends StatefulWidget {
  final QuestionRepository questionRepository;

  const QuestionScreen({
    super.key,
    required this.questionRepository,
  });

  @override
  State<QuestionScreen> createState() {
    return _QuestionScreen();
  }
}

class _QuestionScreen extends State<QuestionScreen> {
  // text controller to access what the user typed
  final textController = TextEditingController();
  int _seletedBottomNavigationIndex = 0;

  // create an answer
  void createAnswer() {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        content: TextField(
          controller: textController,
        ),
        actions: [
          // create button
          MaterialButton(
            onPressed: () {
              // add to db
              context
                  .read<AnswerDatabase>()
                  .addAnswer(currentQuestion.id, textController.text);

              // clear controller
              textController.clear();

              // pop dialog box
              Navigator.pop(context);
            },
            child: const Text("Create"),
          )
        ],
      ),
    );
  }

  // read answers
  void readAnswers(int questionId) {
    context.watch<AnswerDatabase>().fetchAnswers(questionId);
  }

  // update an answer
  void updateAnswer(Answer answer) {
    // pre-fill the current answer text
    textController.text = answer.text;
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text("Update Answer"),
        content: TextField(controller: textController),
        actions: [
          // update button
          MaterialButton(
            onPressed: () {
              // update answer in db
              context
                  .read<AnswerDatabase>()
                  .updateAnswer(answer.id, textController.text);
              // clear controller
              textController.clear();
              // pop dialog box
              Navigator.pop(context);
            },
            child: const Text("Update"),
          )
        ],
      ),
    );
  }

  // delete an answer
  void deleteAnswer(int id) {
    context.read<AnswerDatabase>().deleteAnswer(id);
  }

  @override
  void initState() {
    super.initState();
    _loadQuestion();
  }

  @override
  didChangeDependencies() {
    super.didChangeDependencies();
    readAnswers(currentQuestion.id);
  }

  var currentQuestionIndex = 0;
  late Question currentQuestion = getDummyQuestionByMonthDay(month: 1, day: 1);

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
    final answerDatabase = context.watch<AnswerDatabase>();
    List<Answer> currentAnswers = answerDatabase.currentAnswers;
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
      bottomNavigationBar: SizedBox(
        height: 150,
        child: BottomNavigationBar(
          type: BottomNavigationBarType.fixed, // item이 4개 이상일 경우 추가
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home),
              label: 'Home',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.groups),
              label: 'Group',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.person),
              label: 'Profile',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.settings),
              label: 'Settings',
            ),
          ],

          currentIndex: _seletedBottomNavigationIndex,
          selectedItemColor: Colors.blueAccent,
          onTap: (int index) {
            _seletedBottomNavigationIndex = index;

            if (index == 1) {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => const GroupScreen(),
                ),
              );
            } else if (index == 2) {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => const ProfileScreen(),
                ),
              );
            }
          },
        ),
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
              Expanded(
                child: ListView.builder(
                    itemCount: currentAnswers.length,
                    itemBuilder: (context, index) {
                      final answer = currentAnswers[index];
                      return ListTile(
                        title: Text(answer.text),
                        trailing: Row(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            // edit button
                            IconButton(
                                onPressed: () => updateAnswer(answer),
                                icon: const Icon(Icons.edit)),
                            // delete button
                            IconButton(
                                onPressed: () => deleteAnswer(answer.id),
                                icon: const Icon(Icons.delete))
                          ],
                        ),
                      );
                    }),
              ),
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
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: createAnswer,
        child: const Icon(Icons.add),
      ),
    );
  }
}
