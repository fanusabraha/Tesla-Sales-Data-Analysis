 Overview
This assignment focuses on analyzing Tesla vehicle sales data from 2016 to 2019 using Java. You'll read data from three CSV files (Model 3, Model S, Model X) and generate sales reports. The key task is leveraging Java Streams for data processing and reporting.

Objectives
Read sales data from CSV files and store it in Java lists.
Use Java Streams to analyze and process the data.
Generate yearly sales reports for each model.
Identify the best and worst sales months for each model.
What You Will Learn
File Handling: Read CSV files and parse their data into Java.
Streams API: Use Java Streams to filter, map, and aggregate data efficiently.
Data Grouping: Organize and group data for reporting purposes.
Date Formatting: Parse and handle dates using DateTimeFormatter (with Locale for international users).
Tasks
Sales Report Output:

Yearly Sales: Total sales for each year (2016–2019).
Best/Worst Months: Identify months with the highest and lowest sales for each model.
CSV Files:
Download the datasets for analysis:

model3.csv
modelS.csv
modelX.csv
Hint for Success:

Load data into three separate Lists.
Stream through each list to calculate yearly totals and best/worst months.
Use grouping and mapping in streams for efficient data processing.
Expected Output
Example Sales Report Format:
yaml
Copy code
Model 3 Yearly Sales Report  
---------------------------  
2017 -> 12345  
2018 -> 23456  
2019 -> 34567  

The best month for Model 3 was: 2018-06  
The worst month for Model 3 was: 2017-02  
Repeat this format for Model S and Model X.
Skills Practiced
Working with Java Streams for data analysis.
Parsing and grouping CSV data.
Manipulating dates using DateTimeFormatter.
Extracting insights and reporting from raw data.
Extension Ideas
Visualization: Use a library (e.g., JFreeChart) to create charts for yearly or monthly trends.
Dynamic Input: Allow users to query specific years or models interactively.
Error Handling: Handle missing or corrupted data gracefully.
This assignment helps solidify your knowledge of file handling, streams, and date processing in Java!
