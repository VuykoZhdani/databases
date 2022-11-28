package ua.lviv.iot.dao.impl;
import ua.lviv.iot.dao.SolarPanelDao;
import ua.lviv.iot.domain.SolarPanel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class SolarPanelDaoImpl implements SolarPanelDao {
    private static final String FIND_ALL = "SELECT * FROM solar_panel";
    private static final String CREATE = "INSERT solar_panel(model, type, current_angle, ip_address_id) VALUES (?, " +
            "?,?,?)";
    private static final String UPDATE = "UPDATE solar_panel SET model=?, type=?, current_angle=?, ip_address_id=? WHERE" +
            " id=?";
    private static final String DELETE = "DELETE FROM solar_panel WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM solar_panel WHERE id=?";
    private static final String FIND_BY_SOLAR_PANEL_IP_ADDRESS = "SELECT * FROM solar_panel WHERE ip_address_id=?";
    private static final String FIND_BY_SOLAR_PANEL_CURRENT_ANGLE = "SELECT * FROM solar_panel WHERE current_angle=?";
    private final JdbcTemplate jdbcTemplate;

    public SolarPanelDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SolarPanel> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(SolarPanel.class));
    }

    @Override
    public Optional<SolarPanel> findById(Integer id) {
        Optional<SolarPanel> solarPanel;
        try {
            solarPanel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(SolarPanel.class), id));
        } catch (EmptyResultDataAccessException e) {
            solarPanel = Optional.empty();
        }
        return solarPanel;
    }

    @Override
    public int create(SolarPanel solarPanel) {
        return jdbcTemplate.update(CREATE, solarPanel.getModel(), solarPanel.getType(),
                solarPanel.getCurrentAngle(), solarPanel.getIp_address_id());
    }

    @Override
    public int update(Integer id, SolarPanel solarPanel) {
        return jdbcTemplate.update(UPDATE, solarPanel.getModel(), solarPanel.getType(),
                solarPanel.getCurrentAngle(), solarPanel.getIp_address_id(),id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<SolarPanel> findByIPaddress(Integer IPaddressId) {
        Optional<SolarPanel> solarPanel;
        try {
            solarPanel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SOLAR_PANEL_IP_ADDRESS,
                    BeanPropertyRowMapper.newInstance(SolarPanel.class), IPaddressId));
        } catch (EmptyResultDataAccessException e) {
            solarPanel = Optional.empty();
        }
        return solarPanel;
    }

    @Override
    public Optional<SolarPanel> findByCurrentAngle(Integer current_angle) {
        Optional<SolarPanel> solarPanel;
        try {
            solarPanel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SOLAR_PANEL_CURRENT_ANGLE,
                    BeanPropertyRowMapper.newInstance(SolarPanel.class), current_angle));
        } catch (EmptyResultDataAccessException e) {
            solarPanel = Optional.empty();
        }
        return solarPanel;
    }
}
