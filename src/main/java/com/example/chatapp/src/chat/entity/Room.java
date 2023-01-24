package com.example.chatapp.src.chat.entity;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Room {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
    @ColumnDefault("''")
    private String profileImgUrl;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @ColumnDefault("'ACTIVE'")
    private String status;



    // @Column  // 이름, 생성조건 등 만들 수 있다.
    // @Temporal() // 날짜,시간 관련 자료형 // LocalDateTime 쓰면 생략가능!
    // @Enumerated(EnumType.STRING) // 무조건 이렇게 하기
    // @Lob
    // @Transient

    // @Column 속성
    //   name                       필드와 매핑할 테이블의 컬럼 이름
    //   insertable, updatable      등록, 변경 가능 여부
    //   nullable(DDL)      null 값의 허용 여부를 설정한다. false로 설정하면 DDL 생성 시에 not null 제약조건이 붙는다.
    //   unique(DDL)        @Table의 uniqueConstraints와 같지만 한 컬럼에 간단히 유니크 제 약조건을 걸 때 사용한다.
    //   columnDefinition   (DDL) 데이터베이스 컬럼 정보를 직접 줄 수 있다.   ex) varchar(100) default ‘EMPTY'
    //   length(DDL)        문자 길이 제약조건, String 타입에만 사용한다.
    //   precision, scale(DDL) 정수의 소숫점 자릿수 관리(???)
}
