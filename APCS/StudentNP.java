import java.util.*;

public class StudentNP 
{
    private String name;
    private int gradYear;
    private String gender;
    ArrayList <Double> testGrades = new ArrayList<Double>();
    private double average;

public StudentNP()
{
    name = "";
    gradYear = 0;
    gender = "";
    testGrades = new ArrayList<Double>();
    average = 0.0;
}
public StudentNP(String n, int gr, String ge, ArrayList <Double> tG, double avg)
{
    name = n;
    gradYear = gr;
    gender = ge;
    testGrades = tG;
    average = avg;
}

public void setName (String n)
{
    name = n;
}
public String getName ()
{
    return name;
}
public void setGradYear (int gr)
{
    gradYear = gr;
}
public int getGradYear ()
{
    return gradYear;
}
public void setGender (String ge)
{
    gender = ge;
}
public String getGender ()
{
    return gender;
}
public void setTestGrades (ArrayList <Double> tG)
{
    for (int i = 0; i < tG.size(); i++)
    {
        testGrades.add(tG.get(i));
    }
}
public ArrayList getTestGrades ()
{
    return testGrades;
}
public void setAverage (double avg)
{
    average = avg;
}
public double getAverage ()
{
    return average;
}

public String toString()
{
    return "Name: " + name + ", Graduation Year: " + gradYear + ", Gender: " + gender + ", Test Grades " + testGrades + ", Average: " + average;
}
}
