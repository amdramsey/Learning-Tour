module People

  class Person

    def initialize(first_name, last_name, age)

      @first_name = first_name
      @last_name = last_name
      @age = age

    end

    def set_first_name(first_name)

      @first_name = first_name

    end

    def get_first_name

      @first_name

    end

    def set_last_name(last_name)

      @last_name = last_name

    end

    def get_last_name

      @last_name

    end

    def set_age(age)

      @age = age

    end

    def get_age

      @age

    end

    def return_string

      "My first name is: #{@first_name}, And my last name is: #{@last_name}, And my age is: #{@age.to_s}"


    end

  end

  class Doctor< Person

    def initialize(first_name, last_name, age, specialization)

      @first_name = first_name
      @last_name = last_name
      @age = age
      @specialization = specialization

    end

    def set_specialization(specialization)

      @specialization = specialization

    end

    def get_specialization

      @specialization

    end

    def return_string

      "My first name is: #{@first_name}, my last name is: #{@last_name}, my age is: #{@age.to_s}, And my specialization is: #{@specialization}"

    end

  end

  class Programmer< Doctor

    def initialize(first_name, last_name, age, specialization, skills)

      @first_name = first_name
      @last_name = last_name
      @age = age
      @specialization = specialization
      @skills = skills

    end

    def set_skills(skills)

      @skills = skills

    end

    def get_skills

      @skills

    end

    def return_string

      "My first name is: #{@first_name}, my last name is: #{@last_name}, my age is: #{@age.to_s}, my specialization is: #{@specialization}, And my skills is:\n\t#{@skills}"

    end

  end

end