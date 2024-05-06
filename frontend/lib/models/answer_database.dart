import 'dart:async';

import 'package:moondab/models/answer.dart';
import 'package:flutter/material.dart';
import 'package:isar/isar.dart';
import 'package:path_provider/path_provider.dart';

class AnswerDatabase extends ChangeNotifier {
  static late Isar isar;

  // INIT
  static Future<void> initialize() async {
    final dir = await getApplicationDocumentsDirectory();
    isar = await Isar.open(
      [AnswerSchema],
      directory: dir.path,
    );
  }

  // list of answers
  final List<Answer> currentAnswers = [];

  // CREATE
  Future<void> addAnswer(int questionId, String textFromUser) async {
    final newAnswer = Answer(questionId, textFromUser);
    await isar.writeTxn(() => isar.answers.put(newAnswer));
    fetchAnswers(questionId);
  }

  // READ
  Future<void> fetchAnswers(int questionId) async {
    List<Answer> fetchedAnswers =
        await isar.answers.filter().questionIdEqualTo(questionId).findAll();
    currentAnswers.clear();
    currentAnswers.addAll(fetchedAnswers);
    notifyListeners();
  }

  // UPDATE
  Future<void> updateAnswer(int id, String newText) async {
    final existingAnswer = await isar.answers.get(id);
    if (existingAnswer != null) {
      existingAnswer.text = newText;
      await isar.writeTxn(() => isar.answers.put(existingAnswer));
      fetchAnswers(existingAnswer.questionId);
    }
  }

  // DELETE
  Future<void> deleteAnswer(int id) async {
    final existingAnswer = await isar.answers.get(id);
    if (existingAnswer != null) {
      await isar.writeTxn(() => isar.answers.delete(id));
      fetchAnswers(existingAnswer.questionId);
    }
  }
}
