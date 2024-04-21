import 'package:adv_basics/models/answer_database.dart';
import 'package:adv_basics/question.dart';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'firebase_options.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  await AnswerDatabase.initialize();

  runApp(const Question());
}
