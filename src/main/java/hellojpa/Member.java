package hellojpa;

import jakarta.persistence.*;

import java.util.Date;


@Entity
/*@SequenceGenerator(name = "member_seq_generator",
sequenceName = "member_seq",
initialValue = 1, allocationSize = 50)
/*@TableGenerator(
        name = "member_seq_generator",
        table = "my_sequence",
        pkColumnValue = "member_seq", allocationSize = 1
)*/

public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    //@Column(name = "TEAM_ID")
    //private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
