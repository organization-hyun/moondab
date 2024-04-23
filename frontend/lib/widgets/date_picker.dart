import 'package:flutter/cupertino.dart';

class MonthDayPicker extends StatefulWidget {
  final DateTime initialDate;
  final Function(DateTime) onDateChanged;

  const MonthDayPicker(
      {super.key, required this.initialDate, required this.onDateChanged});

  @override
  _MonthDayPickerState createState() => _MonthDayPickerState();
}

class _MonthDayPickerState extends State<MonthDayPicker> {
  late DateTime _selectedDate;

  @override
  void initState() {
    super.initState();
    _selectedDate = widget.initialDate;
  }

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 200,
      child: CupertinoDatePicker(
        mode: CupertinoDatePickerMode.date,
        initialDateTime: _selectedDate,
        dateOrder: DatePickerDateOrder.ymd,
        minimumDate: DateTime(_selectedDate.year - 1),
        maximumDate: DateTime(_selectedDate.year + 1),
        onDateTimeChanged: (DateTime newDate) {
          setState(() {
            _selectedDate = newDate;
          });
          widget.onDateChanged(_selectedDate);
        },
      ),
    );
  }
}
