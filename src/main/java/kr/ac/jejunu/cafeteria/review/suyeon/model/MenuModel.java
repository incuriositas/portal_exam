package kr.ac.jejunu.cafeteria.review.suyeon.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="menu")
public class MenuModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String day;
    private String weekend;
    private String division;
    private String lunch;
    private String dinner;
}
