import "package:isar/isar.dart";

part 'answer.g.dart';

// flutter pub run build_runner build
@collection
class Answer {
  Id id = Isar.autoIncrement;
  late int questionId;
  late String text;

  Answer(this.questionId, this.text);
}
