This project is a module designed to filter a set of flights based on various dynamic rules. 
Each flight is composed of one or more segments, where each segment represents a direct travel portion between two locations. 
Segments are characterized by two key attributes: departure time and arrival time.
The module is intended to handle potentially large datasets of flights and applies different filtering criteria based on the context of execution. 
The rules for filtering are applied dynamically and can be extended in the future.

## Features

1. Flight Structure:
- A flight consists of multiple segments, each representing an atomic flight operation.
- Each segment has a departure and an arrival time.

2. Filtering Rules: The module provides filtering options based on the following rules:
- Past Departure: Excludes flights where the departure time is earlier than the current time.
- Arrival Before Departure: Excludes flights where any segment has an arrival time before its corresponding departure time.
- Excessive Ground Time: Excludes flights where the total time spent on the ground between segments exceeds two hours.

3. Dynamic Filtering:
- Filters can be applied dynamically based on the context of the operation.
- The module is designed to allow the addition of new filtering rules in the future.

4. Test Cases:
- The module includes a set of JUnit 5 test cases that verify the correct functionality of each filtering rule.
