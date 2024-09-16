package com.poly.workshop.repository;

import com.poly.workshop.entity.MayTinh;
import com.poly.workshop.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MayTinhRepository {

    public List<MayTinh> getAll() {
        String sql = """
                SELECT id, ma, ten, gia, bo_nho, mau_sac, hang, mieu_ta
                FROM FA24_BL1_WORKSHOP_DEMO.dbo.may_tinh;
                """;
        List<MayTinh> lists = new ArrayList<>();
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MayTinh mt = new MayTinh();
                mt.setId(rs.getLong(1));
                mt.setMa(rs.getString(2));
                mt.setTen(rs.getString(3));
                mt.setGia(rs.getDouble(4));
                mt.setBoNho(rs.getString(5));
                mt.setMauSac(rs.getString(6));
                mt.setHang(rs.getString(7));
                mt.setMieuTa(rs.getString(8));
                lists.add(mt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public MayTinh getOne(Long id) {
        String sql = """
                SELECT id, ma, ten, gia, bo_nho, mau_sac, hang, mieu_ta
                FROM FA24_BL1_WORKSHOP_DEMO.dbo.may_tinh
                WHERE id = ?
                """;
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MayTinh mt = new MayTinh();
                mt.setId(rs.getLong(1));
                mt.setMa(rs.getString(2));
                mt.setTen(rs.getString(3));
                mt.setGia(rs.getDouble(4));
                mt.setBoNho(rs.getString(5));
                mt.setMauSac(rs.getString(6));
                mt.setHang(rs.getString(7));
                mt.setMieuTa(rs.getString(8));
                return mt;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(MayTinh mayTinh) {
        String sql = """
                INSERT INTO FA24_BL1_WORKSHOP_DEMO.dbo.may_tinh
                (ma, ten, gia, bo_nho, mau_sac, hang, mieu_ta)
                VALUES(?,?,?,?,?,?,?);
                 """;
        int check = 0; // false
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mayTinh.getMa());
            ps.setObject(2, mayTinh.getTen());
            ps.setObject(3, mayTinh.getGia());
            ps.setObject(4, mayTinh.getBoNho());
            ps.setObject(5, mayTinh.getMauSac());
            ps.setObject(6, mayTinh.getHang());
            ps.setObject(7, mayTinh.getMieuTa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(MayTinh newMayTinh, Long id) {
        String sql = """
                UPDATE FA24_BL1_WORKSHOP_DEMO.dbo.may_tinh
                  SET ma=?, ten=?, gia=?, bo_nho=?, mau_sac=?, hang=?, mieu_ta=?
                  WHERE id=?;
                 """;
        int check = 0; // false
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, newMayTinh.getMa());
            ps.setObject(2, newMayTinh.getTen());
            ps.setObject(3, newMayTinh.getGia());
            ps.setObject(4, newMayTinh.getBoNho());
            ps.setObject(5, newMayTinh.getMauSac());
            ps.setObject(6, newMayTinh.getHang());
            ps.setObject(7, newMayTinh.getMieuTa());
            ps.setObject(8, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean remove(Long id) {
        String sql = """
                DELETE FROM FA24_BL1_WORKSHOP_DEMO.dbo.may_tinh
                                      WHERE id=?;
                 """;
        int check = 0; // false
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
