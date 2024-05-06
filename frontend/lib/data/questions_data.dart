import 'package:moondab/models/questions.dart';

const questions = [
  Question(
    1,
    '새해 소망이나 계획 중에서 가장 중요한 것은 무엇인가요?',
    1,
    1,
  ),
  Question(
    2,
    '새해 결심을 어떻게 실천할 계획인가요?',
    1,
    2,
  ),
  Question(
    3,
    '이번 주에 무엇을 이루고 싶으신가요?',
    1,
    3,
  ),
  Question(
    4,
    '올해 목표를 달성하기 위한 계획은 무엇인가요?',
    1,
    4,
  ),
  Question(
    5,
    '가장 큰 두려움은 무엇이며, 그것을 어떻게 극복할 계획인가요?',
    1,
    5,
  ),
  Question(
    6,
    '당신이 지금 삶에서 가장 감사하게 생각하는 것은 무엇인가요?',
    1,
    6,
  ),
  Question(
    7,
    '올해 배우고 싶은 새로운 기술이나 취미는 무엇인가요?',
    1,
    7,
  ),
  Question(
    8,
    '최근에 당신에게 큰 영향을 미친 책 또는 영화는 무엇인가요?',
    1,
    8,
  ),
  Question(
    9,
    '자신을 바꾸고 싶은 한 가지는 무엇인가요?',
    1,
    9,
  ),
  Question(
    10,
    '어떻게 하면 세상에 긍정적인 변화를 가져올 수 있을지 계획해보세요.',
    1,
    10,
  ),
];

Question getDummyQuestionByMonthDay({required int month, required int day}) {
  DateTime now = DateTime.now();
  DateTime fromDate = DateTime(now.year, now.month, now.day);
  DateTime toDate = DateTime(2024, month, day);

  final int index = toDate.difference(fromDate).inDays;

  // 질문의 수가 모자라기 때문에 index 에러 방지
  return index >= questions.length || index < 0
      ? questions[0]
      : questions[index];
}
