package com.example.finalexam.repositories;

import com.example.finalexam.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ItemsRepository  {

    private final JdbcTemplate jdbc;

    public ItemsRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Items> getAllItems(){
        String sql = "SELECT * FROM items";
        RowMapper<Items> itemRowMapper = (r, i) -> {
            Items rowObject = new Items();
            rowObject.setCatcode(r.getString("Catcode"));
            rowObject.setIcode(r.getString("Icode"));
            rowObject.setIdesc(r.getString("Idesc"));
            rowObject.setPrice(r.getFloat("Price"));

            return rowObject;
        };

        List<Items> itemsList = jdbc.query(sql, itemRowMapper);
        return itemsList;
    }

    public void createItem(int recno, String icode, double qty, Date dot) {
        String sql = "INSERT INTO `sales`(`recno`, `icode`, `qty`, `dot`) VALUES ('?','?','?','?')";
        jdbc.update(sql, recno, icode, qty, dot);
    }
}