package com.example.demo.mappers;

import com.example.demo.dtos.grade.GradeRequest;
import com.example.demo.dtos.grade.GradeResponse;
import com.example.demo.entities.Course;
import com.example.demo.entities.Evaluation;
import com.example.demo.entities.Grade;
import com.example.demo.entities.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-23T15:44:29-0400",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class GradeMapperImpl implements GradeMapper {

    @Override
    public Grade toEntity(GradeRequest request) {
        if ( request == null ) {
            return null;
        }

        Grade grade = new Grade();

        grade.setValueDecimal( request.getValueDecimal() );
        grade.setFeedback( request.getFeedback() );

        return grade;
    }

    @Override
    public GradeResponse toResponse(Grade grade) {
        if ( grade == null ) {
            return null;
        }

        GradeResponse.GradeResponseBuilder gradeResponse = GradeResponse.builder();

        gradeResponse.studentId( gradeStudentId( grade ) );
        gradeResponse.evaluationId( gradeEvaluationId( grade ) );
        gradeResponse.evaluationName( gradeEvaluationName( grade ) );
        gradeResponse.courseName( gradeEvaluationCourseName( grade ) );
        gradeResponse.id( grade.getId() );
        gradeResponse.valueDecimal( grade.getValueDecimal() );
        gradeResponse.feedback( grade.getFeedback() );
        gradeResponse.passed( grade.isPassed() );

        gradeResponse.studentName( grade.getStudent().getName() + " " + grade.getStudent().getLastName() );

        return gradeResponse.build();
    }

    @Override
    public void updateEntityFromRequest(GradeRequest request, Grade grade) {
        if ( request == null ) {
            return;
        }

        grade.setValueDecimal( request.getValueDecimal() );
        grade.setFeedback( request.getFeedback() );
    }

    private Long gradeStudentId(Grade grade) {
        Student student = grade.getStudent();
        if ( student == null ) {
            return null;
        }
        return student.getId();
    }

    private Long gradeEvaluationId(Grade grade) {
        Evaluation evaluation = grade.getEvaluation();
        if ( evaluation == null ) {
            return null;
        }
        return evaluation.getId();
    }

    private String gradeEvaluationName(Grade grade) {
        Evaluation evaluation = grade.getEvaluation();
        if ( evaluation == null ) {
            return null;
        }
        return evaluation.getName();
    }

    private String gradeEvaluationCourseName(Grade grade) {
        Evaluation evaluation = grade.getEvaluation();
        if ( evaluation == null ) {
            return null;
        }
        Course course = evaluation.getCourse();
        if ( course == null ) {
            return null;
        }
        return course.getName();
    }
}
