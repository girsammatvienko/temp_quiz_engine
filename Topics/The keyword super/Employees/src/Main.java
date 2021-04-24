
class Employee {
    protected String name;
    protected String email;
    protected int experience;
    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
}

class Developer extends Employee {
    private String[] skills;
    private String mainLanguage;
    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }
    public String[] getSkills() {
        return skills;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

}

class DataAnalyst extends Employee {
    private boolean phd;
    private String[] methods;
    public DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods;
    }

    public boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }
}