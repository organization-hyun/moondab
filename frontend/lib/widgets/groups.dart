import 'package:flutter/material.dart';
import 'package:moondab/models/group.dart';
import 'package:moondab/widgets/groups_list/groups_list.dart';

class Groups extends StatefulWidget {
  const Groups({super.key});

  @override
  State<Groups> createState() {
    return _GroupState();
  }
}

class _GroupState extends State<Groups> {
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
      numOfPosts: 5,
      numOfUsers: 2,
    ),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          const Text('Group list header'),
          Expanded(
            child: GroupsList(groups: _userGroups),
          ),
        ],
      ),
    );
  }
}
