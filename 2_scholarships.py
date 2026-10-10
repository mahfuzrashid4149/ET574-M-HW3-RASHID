import csv

students = {}

with open("students.csv", "r") as file:
    reader = csv.DictReader(file)

    for row in reader:
        name = row["Name"]
        major = row["Major"]
        gpa = float(row["GPA"])

        if gpa >= 0.0 and gpa <= 4.0:
            students[name] = [major, gpa]

total = 0

for name in students:
    total = total + students[name][1]

average = total / len(students)

print("Average GPA:", format(average, ".2f"))
print()
print("Above Average Students:")

for name in students:
    major = students[name][0]
    gpa = students[name][1]

    if gpa > average:
        print(name, format(gpa, ".2f"), major)

print()
print("Scholarship Students:")

for name in students:
    major = students[name][0]
    gpa = students[name][1]

    if major == "Biology" and gpa >= 2.75:
        scholarship = "earned a scholarship."
    elif major == "Math" and gpa >= 3.50:
        scholarship = "earned a scholarship."
    else:
        scholarship = "did not earn a scholarship."

    print(name, format(gpa, ".2f"), major, scholarship)