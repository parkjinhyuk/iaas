package jinhyuk.domain.loadbalancers;

import jinhyuk.domain.clusters.Clusters;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class LoadBalancers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String loadBalancerInstanceNo;

    @Column(unique = true)
    private String loadBalancerName;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "loadBalancers")
    private Clusters clusters;


    @Builder
    public LoadBalancers(String loadBalancerInstanceNo, String loadBalancerName) {
        this.loadBalancerName = loadBalancerName;
        this.loadBalancerInstanceNo = loadBalancerInstanceNo;
    }
}
