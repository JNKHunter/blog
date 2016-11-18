package tech.eats.art.blog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.eats.art.blog.model.Category;

import java.util.List;

/**
 * Created by John on 11/17/16.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        //Open a session
        Session session = sessionFactory.openSession();

        // Get all categories with a Hibernate criteria
        List<Category> categories = session.createCriteria(Category.class).list();

        //Close session
        session.close();

        return categories;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {

        //Open a session
        Session session = sessionFactory.openSession();

        //Begin a transaction
        session.beginTransaction();

        //Save the category
        session.save(category);

        //Commit transaction
        session.getTransaction().commit();

        //Close session
        session.close();

    }

    @Override
    public void delete(Category category) {

    }
}
