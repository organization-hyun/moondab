import 'package:flutter/material.dart';

class GroupScreen extends StatefulWidget {
  const GroupScreen({super.key});

  @override
  _GroupScreenState createState() => _GroupScreenState();
}

class _GroupScreenState extends State<GroupScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Group Screen'),
      ),
      body: Container(
        child: const Center(
          child: Text('Hello, Group Screen!'),
        ),
      ),
    );
  }
}
