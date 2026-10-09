# list of three students named Jon, Kim and Lee
students = ["Jon", "Kim", "Lee"]

# add more students after the list is created
students.append("Sara")
students.append("Miko")
# change Jon to John
students[0] = 'John'
# function to print 'Hi name' for each student in the list
def print_greetings(student_list):
    print(f"Total students: {len(student_list)}")
    for name in student_list:
        print(f"Hi {name}")

# call the function
print_greetings(students)