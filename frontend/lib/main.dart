import 'package:moondab/models/answer_database.dart';
import 'package:moondab/question.dart';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:provider/provider.dart';
import 'firebase_options.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  await AnswerDatabase.initialize();

  runApp(
    ChangeNotifierProvider(
      create: (context) => AnswerDatabase(),
      child: const Question(),
    ),
  );
}
