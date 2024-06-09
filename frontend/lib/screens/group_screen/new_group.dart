import 'package:flutter/material.dart';
import 'package:moondab/models/group.dart';

class NewGroup extends StatefulWidget {
  const NewGroup({super.key, required this.onAddGroup});

  final void Function(Group group) onAddGroup;

  @override
  State<StatefulWidget> createState() {
    return _NewGroup();
  }
}

class _NewGroup extends State<NewGroup> {
  final _titleController = TextEditingController();

  void _submitGroupData() {
    if (_titleController.text.trim().isEmpty) {
      showDialog(
        context: context,
        builder: (ctx) => AlertDialog(
          title: const Text('Invalid input'),
          content: const Text('제목은 한 글자 이상이어야 합니다.'),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.pop(ctx);
              },
              child: const Text('Okay'),
            )
          ],
        ),
      );
      return;
    }

    widget.onAddGroup(
      Group(
        title: _titleController.text,
        numOfPosts: 0,
        numOfUsers: 1,
        createDateTime: DateTime.now(),
        category: null,
      ),
    );
    Navigator.pop(context);
  }

  @override
  void dispose() {
    _titleController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        children: [
          TextField(
            controller: _titleController,
            maxLength: 50,
            decoration: const InputDecoration(
              label: Text('Title'),
            ),
          ),
          Row(
            children: [
              TextButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Text('Cancle'),
              ),
              ElevatedButton(
                onPressed: _submitGroupData,
                child: const Text('Save Group'),
              ),
            ],
          )
        ],
      ),
    );
  }
}
