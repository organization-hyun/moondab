import 'package:adv_basics/models/group.dart';
import 'package:adv_basics/widgets/groups_list/groups_item.dart';
import 'package:flutter/material.dart';

class GroupsList extends StatelessWidget {
  const GroupsList({
    super.key,
    required this.groups,
  });

  final List<Group> groups;

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: groups.length,
      itemBuilder: (ctx, index) => GroupItem(groups[index]),
    );
  }
}
