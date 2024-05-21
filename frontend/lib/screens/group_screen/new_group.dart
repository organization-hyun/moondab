import 'package:flutter/material.dart';

class NewGroup extends StatefulWidget {
  const NewGroup({super.key});

  @override
  State<StatefulWidget> createState() {
    return _NewGroup();
  }
}

class _NewGroup extends State<NewGroup> {
  @override
  Widget build(BuildContext context) {
    return const Padding(
      padding: EdgeInsets.all(16),
      child: Column(
        children: [
          TextField(
            maxLength: 50,
            decoration: InputDecoration(label: Text('Title')),
          ),
        ],
      ),
    );
  }
}
