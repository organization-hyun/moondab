import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

final formatter = DateFormat.yMd();

enum Category { love, work, book, movie }

const categoryIcons = {
  Category.love: Icons.favorite,
  Category.work: Icons.work,
  Category.book: Icons.book,
  Category.movie: Icons.movie,
};

class Group {
  Group({
    required this.title,
    required this.numOfPosts,
    required this.numOfUsers,
    required this.createDateTime,
    required this.category,
  });

  final String title;
  final int numOfPosts;
  final int numOfUsers;
  final DateTime createDateTime;
  final Category? category;

  String get formattedDate {
    return formatter.format(createDateTime);
  }
}
