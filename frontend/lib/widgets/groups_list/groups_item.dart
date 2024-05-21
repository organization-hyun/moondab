import 'package:flutter/material.dart';
import 'package:moondab/models/group.dart';

class GroupItem extends StatelessWidget {
  const GroupItem(this.group, {super.key});

  final Group group;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Padding(
        padding: const EdgeInsets.symmetric(
          horizontal: 20,
          vertical: 16,
        ),
        child: Column(
          children: [
            Text(group.title),
            const SizedBox(height: 4),
            Row(
              children: [
                Row(
                  children: [
                    const Icon(Icons.people),
                    const SizedBox(width: 8),
                    Text('${group.numOfUsers.toString()}명'),
                  ],
                ),
                const Spacer(),
                Row(
                  children: [
                    Icon(categoryIcons[group.category]),
                    Text('${group.numOfPosts.toString()}개'),
                    const SizedBox(width: 8),
                    Text(group.formattedDate),
                  ],
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
