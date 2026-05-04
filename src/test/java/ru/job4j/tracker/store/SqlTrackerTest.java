package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenFindAllThenReturnAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        List<Item> result = tracker.findAll();
        assertThat(result).containsExactlyInAnyOrder(item1, item2);
    }

    @Test
    public void whenFindByNameThenReturnMatchingItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("java"));
        Item item2 = tracker.add(new Item("java"));
        tracker.add(new Item("python"));
        List<Item> result = tracker.findByName("java");
        assertThat(result).containsExactlyInAnyOrder(item1, item2);
    }

    @Test
    public void whenReplaceThenItemIsUpdated() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("old"));
        Item updated = new Item("new");
        boolean result = tracker.replace(item.getId(), updated);
        Item actual = tracker.findById(item.getId());
        assertThat(result).isTrue();
        assertThat(actual.getName()).isEqualTo("new");
    }

    @Test
    public void whenDeleteThenItemIsRemoved() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("toDelete"));
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }
}