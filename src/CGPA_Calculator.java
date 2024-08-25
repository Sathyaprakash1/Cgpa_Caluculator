import java.util.*;
public class CGPA_Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Upto which sem you want to calculate your CGPA: ");
        int Sem = sc.nextInt();

        int[] x = new int[]{0, 9, 16, 24, 32, 42, 52, 59};
        int[] y = new int[]{8, 15, 23, 31, 41, 51, 58, 61};
        double[] gpa_credit_sum = new double[Sem];
        double[] gpa_gradepoint_sum = new double[Sem];
        double[] result_gpa = new double[Sem], result_cgpa = new double[Sem];

        String[] array = new String[]{ // 1st SEMESTER
                "SEM1 : MA20101 - Mathematics and Calculus",
                "SEM1 : EN20101 - English Communication Skills I",
                "SEM1 : PH20101 - Engineering Physics",
                "SEM1 : CH20101 - Engineering Chemistry",
                "SEM1 : ME20101 - Engineering Graphics",
                "SEM1 : CS20101 - Programming in Python",
                "SEM1 : PH20102 - Physics Laboratory",
                "SEM1 : CH20102 - Chemistry Laboratory",
                "SEM1 : CS20103 - Programming in Python Lab",
                // 2nd SEMESTER
                "SEM2 : EN0201 - English Communication Skills II",
                "SEM2 : MA0201 - Complex Variables and Differential Equations",
                "SEM2 : PH0201 - Physics for Electronics Engineering",
                "SEM2 : EC0202 - Electrical Circuits and Measurements",
                "SEM2 : EC0201 - Electron Devices",
                "SEM2 : GE0201 - Engineering Practices Laboratory",
                "SEM2 : EC0203 - Circuits and Devices Laboratory",
                // 3rd SEMESTER
                "SEM3 : MA20302 - Linear Algebra and Partial Differential Equations",
                "SEM3 : IT20304 - Fundamentals of Data structures in C",
                "SEM3 : EC20301 - Analog Electronics",
                "SEM3 : EC20302 - Digital Electronics",
                "SEM3 : EC20303 - Electromagnetic Fields and Waves",
                "SEM3 : EC20304 - Analog Electronics Laboratory",
                "SEM3 : EC20305 - Digital Electronics Laboratory",
                "SEM3 : IT20307 - Fundamentals of Data structure in C laboratory",
                // 4th SEMESTER
                "SEM4 : MA20402 - Probability and Random processes",
                "SEM4 : EC20401 - Control Systems",
                "SEM4 : EC20402 - Signals and Systems",
                "SEM4 : EC20403 - Analog Integrated Circuits",
                "SEM4 : EC20404 - Microprocessors and Microcontrollers",
                "SEM4 : EC20405 - Analog Integrated Circuits Laboratory",
                "SEM4 : EC20406 - Microprocessors and Microcontrollers Laboratory",
                "SEM4 : EN20401 - English Proficiency Course laboratory",
                // 5th SEMESTER
                "SEM5 : BA20151 - ENTREPRENEURSHIP DEVELOPMENT",
                "SEM5 : EC20501 - ANALOG AND DIGITAL COMMUNICATION",
                "SEM5 : EC20502 - RF TRANSMISSION LINES",
                "SEM5 : EC20503 - DIGITAL SIGNAL PROCESSING",
                "SEM5 : EC20504 - COMPUTER COMMUNICATION NETWORKS",
                "SEM5 : EC20*** - PE I",
                "SEM5 : EC20505 - DIGITAL SIGNAL PROCESSING LABORATORY",
                "SEM5 : EC20506 - COMMUNICATION AND NETWORKS LABORATORY",
                "SEM5 : EN20501 - CAREER DEVELOPMENT LABORATORY I",
                "SEM5 : EP20951 - SOFT SKILL LABORATORY I",
                // 6th SEMESTER
                "SEM6 : EC20601 - EMBEDDED SYSTEMS",
                "SEM6 : EC20602 - VLSI DESIGN",
                "SEM6 : EC20603 - WIRELESS COMMUNICATION",
                "SEM6 : EC20*** - PE II",
                "SEM6 : EC20*** - PE III",
                "SEM6 : OE I",
                "SEM6 : EC20604 - EMBEDDED SYSTEMS LABORATORY",
                "SEM6 : EC20605 - VLSI LABORATORY",
                "SEM6 : EP20952 - SOFT SKILL LABORATORY II",
                "SEM6 : EN20601 - CAREER DEVELOPMENT LABORATORY II",
                // 7th SEMESTER
                "SEM7 : EC20701 - ANTENNAS AND WAVE PROPAGATION",
                "SEM7 : EC20702 - OPTICAL AND MICROWAVE COMMUNICATION",
                "SEM7 : EC20*** - PE IV",
                "SEM7 : EC20*** - PE V",
                "SEM7 : OE II",
                "SEM7 : EC20703 - OPTICAL AND MICROWAVE LABORATORY",
                "SEM7 : EC20704 - PROJECT WORK (PHASE I)",
                // 8th SEMESTER
                "SEM8 : EC20801 COGNITIVE RADIO NETWORKS",
                "SEM8 : EC20*** - PE VI",
                "SEM8 : EC20802 PROJECT WORK (PHASE II)"
        };

        int[] Credit_point = new int[]{4, 3, 3, 3, 3, 3, 1, 1, 1, // Sem1, start 0, end 8
                3, 4, 3, 3, 3, 2, 1, // Sem2, start start 9, end 15
                4, 3, 3, 3, 3, 2, 2, 2, // Sem3, start 16, end 23
                4, 3, 4, 3, 3, 2, 2, 1, // Sem4, start 24, end 31
                3, 3, 3, 4, 3, 3, 2, 2, 1, 1, // Sem5, start 32, end 41
                3, 3, 3, 3, 3, 3, 2, 2, 1, 1, // Sem6, start 42, end 51
                3, 3, 3, 3, 3, 2, 3, // Sem7 start 52, end 58
                3, 3, 6 // sem8, start 59, end 61
        };

        double cumulativeGradePointSum = 0;
        double cumulativeCreditSum = 0;

        for (int i = 0; i < Sem; i++) {
            int z = y[i];
            int[] Grade_point = new int[z + 1];

            for (int a = x[i]; a <= z; a++) {
                System.out.print(array[a] + " Enter the grade: ");
                Grade_point[a] = sc.nextInt();
            }

            gpa_credit_sum[i] = 0;
            gpa_gradepoint_sum[i] = 0;

            // gpa calculator
            for (int j = x[i]; j <= z; j++) {
                gpa_gradepoint_sum[i] += Credit_point[j] * Grade_point[j];
                gpa_credit_sum[i] += Credit_point[j];
            }
            result_gpa[i] = gpa_gradepoint_sum[i] / gpa_credit_sum[i];

            // cgpa calculator
            cumulativeGradePointSum += gpa_gradepoint_sum[i];
            cumulativeCreditSum += gpa_credit_sum[i];

            result_cgpa[i] = cumulativeGradePointSum / cumulativeCreditSum;
        }

        for (int i = 0; i < Sem; i++) {
            System.out.printf("Sem %d -> GPA: %.2f, CGPA: %.2f%n", i + 1, result_gpa[i], result_cgpa[i]);
        }

    }

}
