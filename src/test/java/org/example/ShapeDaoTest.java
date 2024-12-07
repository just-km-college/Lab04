package org.example;

import junit.framework.TestCase;
import org.hibernate.SessionFactory;

import java.util.Comparator;
import java.util.List;

public class ShapeDaoTest extends TestCase {

    private static SessionFactory sessionFactory;

    private static final ShapeDao shapeDao = new ShapeDao("hibernateTesting.cfg.xml");
    private final Color color = new Color(100,200,200,200);


    public void testSave() {
        Rectangle rectangle = new Rectangle(color, 123.3, 4.225);
        int num_of_shapes = shapeDao.getAllShapes().size();
        shapeDao.save(rectangle);
        assertEquals(num_of_shapes + 1, shapeDao.getAllShapes().size());
        Shape testing_shape = shapeDao.getById(rectangle.getId());
        assertTrue(testing_shape instanceof Rectangle);
        assertEquals(rectangle.getArea(), testing_shape.getArea(), 0.0001);
    }

    public void testGetAllShapes() {
        List<Shape> shapes1 = shapeDao.getAllShapes();
        Rectangle rectangle = new Rectangle(color, 65.4, 20.3);
        Triangle triangle = new Triangle(color,12 );
        int num_of_shapes = shapeDao.getAllShapes().size();
        shapeDao.save(rectangle);
        shapeDao.save(triangle);
        shapes1.add(rectangle);
        shapes1.add(triangle);
        List<Shape> shapes2 = shapeDao.getAllShapes();
        assertEquals(num_of_shapes + 2, shapes2.size());
        shapes1.sort(Comparator.comparing(Shape::getId));
        shapes2.sort(Comparator.comparing(Shape::getId));
        for (int i = 0; i < shapes1.size(); i++) {
            assertEquals(shapes1.get(i).toString(), shapes2.get(i).toString());
            assertEquals(shapes1.get(i).getColorDescription(), shapes2.get(i).getColorDescription());
        }
    }

    public void testGetById() {
        Rectangle rectangle = new Rectangle(color, 123, 4);
        shapeDao.save(rectangle);
        Shape fetchedShape = shapeDao.getById(rectangle.getId());
        assertNotNull(fetchedShape);
        assertTrue(fetchedShape instanceof Rectangle);
        assertEquals(rectangle.getArea(), fetchedShape.getArea(), 0.0001);
    }

    public void testDeleteById() {
        Rectangle rectangle = new Rectangle(color, 14.2, 411);
        shapeDao.save(rectangle);
        int num_of_shapes = shapeDao.getAllShapes().size();
        shapeDao.deleteById(rectangle.getId());
        assertNull(shapeDao.getById(rectangle.getId()));
        List<Shape> shapes = shapeDao.getAllShapes();
        assertEquals(num_of_shapes - 1, shapes.size());
    }

    public void testUpdate() {
        Rectangle rectangle = new Rectangle(color, 1023, 5);
        shapeDao.save(rectangle);
        rectangle.setA(100.0);
        rectangle.setB(100.0);
        shapeDao.update(rectangle);
        Shape updatedShape = shapeDao.getById(rectangle.getId());
        assertTrue(updatedShape instanceof Rectangle);
        assertEquals(100.0, ((Rectangle) updatedShape).getA(), 0.001);
        assertEquals(100.0, ((Rectangle) updatedShape).getB(), 0.001);
    }
}