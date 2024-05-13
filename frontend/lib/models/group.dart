class Group {
  Group(
      {required this.id,
      required this.title,
      required this.numOfPosts,
      required this.numOfUsers,
      required this.latestDateTime});

  final int id;
  final String title;
  final int numOfPosts;
  final int numOfUsers;
  final DateTime latestDateTime;
}
