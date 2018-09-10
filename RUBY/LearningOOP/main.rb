require "./people"

def main

  person = People::Person.new("Ahmed", "Ramsey", 15)

  puts person.return_string

  doctor = People::Doctor.new("Reda", "Shafiq", 55, "Ear, nose and throat diseases")

  puts doctor.return_string

  programmer = People::Programmer.new("Ahmed", "Ramsey", 15, "DesktopApplications", "Python, JAVA, Kotlin, PHP, C, C++, Swift, JavaScript, VB.NET, And Ruby On Rails")

  puts programmer.return_string

end

main