import 'package:moondab/models/questions.dart';

import 'questions_data.dart';

abstract class QuestionRepository {
  Question getQuestionByMonthDay({
    required int month,
    required int day,
  });
}

class DummyQuestionRepositoryImpl implements QuestionRepository {
  @override
  Question getQuestionByMonthDay({
    required int month,
    required int day,
  }) {
    return getDummyQuestionByMonthDay(month: month, day: day);
  }
}
