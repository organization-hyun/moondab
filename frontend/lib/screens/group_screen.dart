import 'package:adv_basics/models/group.dart';
import 'package:adv_basics/widgets/groups_list/groups_list.dart';
import 'package:flutter/material.dart';

class GroupScreen extends StatefulWidget {
  const GroupScreen({super.key});

  @override
  State<GroupScreen> createState() {
    return _GroupScreenState();
  }
}

class _GroupScreenState extends State<GroupScreen> {
  final List<Group> _userGroups = [
    Group(
      id: 1,
      title: "기본 그룹1",
      numOfPosts: 5,
      numOfUsers: 3,
    ),
    Group(
      id: 2,
      title: "기본 그룹2",
      numOfPosts: 0,
      numOfUsers: 2,
    ),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('내 그룹'),
      ),
      body: Column(
        children: [
          Expanded(
            child: GroupsList(groups: _userGroups),
          ),
        ],
      ),
    );
  }
}