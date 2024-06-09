import 'package:flutter/material.dart';
import 'package:moondab/models/group.dart';
import 'package:moondab/screens/group_screen/groups_list.dart';
import 'package:moondab/screens/group_screen/new_group.dart';

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
      title: "기본 그룹1",
      numOfPosts: 5,
      numOfUsers: 3,
      createDateTime: DateTime.now(),
      category: Category.love,
    ),
    Group(
      title: "기본 그룹2",
      numOfPosts: 0,
      numOfUsers: 2,
      createDateTime: DateTime.now(),
      category: Category.work,
    ),
  ];

  void _openAddGroupOverlay() {
    showModalBottomSheet(
      context: context,
      builder: (ctx) => NewGroup(onAddGroup: _addGroup),
    );
  }

  void _addGroup(Group group) {
    setState(() {
      _userGroups.add(group);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('내 그룹'),
        actions: [
          IconButton(
            onPressed: _openAddGroupOverlay,
            icon: const Icon(Icons.add),
          )
        ],
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
