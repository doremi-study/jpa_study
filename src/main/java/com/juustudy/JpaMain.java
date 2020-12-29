package com.juustudy;

import com.juustudy.domain.Book;
import com.juustudy.domain.BookStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //메인생성 단축키 psvm

        //엔티티 매니저 팩토리 - 생성
        //persistence.xml에서 설정한 이름 <persistence-unit name="juustudy">
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("juustudy");
        //엔티디 매니저 - 생성
        EntityManager em = emf.createEntityManager();
        //트랜잭션 - 획득
        EntityTransaction tx = em.getTransaction();
        try {
            BookStore bookStore = new BookStore();
            bookStore.setName("시애틀책방");
            em.persist(bookStore);

            Book book = new Book();
            book.setTitle("jpa공부좀하세요");

            bookStore.add(book);
            em.persist(book);

            tx.begin(); //트랜잭션 - 시작
            tx.commit(); //트랜잭션 - 커밋
        } catch (Exception e){
            tx.rollback(); //트랜잭션 롤백
        }finally {
            em.close(); //엔티티 매니저 - 종료
        }
        emf.close(); //엔티티 매니저 팩토리 - 종료
    }
}