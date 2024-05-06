import 'package:flutter/material.dart';

class GroupsScreen extends StatefulWidget {
  const GroupsScreen({super.key});

  @override
  _GroupsScreenState createState() => _GroupsScreenState();
}

class _GroupsScreenState extends State<GroupsScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Groups Screen'),
      ),
      body: Container(
        child: const Center(
          child: Text('Hello, Groups Screen!'),
        ),
      ),
    );
  }
}
