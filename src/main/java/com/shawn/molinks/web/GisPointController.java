package com.shawn.molinks.web;

import com.shawn.molinks.entity.Coordinate;
import com.shawn.molinks.entity.MolinksAddress;
import com.shawn.molinks.entity.MolinksAddressVO;
import com.shawn.molinks.service.GisPointConfig;
import com.shawn.molinks.utils.DistanceUtil;
import com.shawn.molinks.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.shawn.molinks.service.GisPointConfig.MOLINKS_ADDRESS_LIST;

@RestController
@RequestMapping("molinks")
public class GisPointController {

    @Autowired
    private GisPointConfig config;

    DecimalFormat df = new DecimalFormat("0.00");


    /**
     * 检查全量数据是否导入成功
     *
     * @return
     */
    @GetMapping("getAllDetail")
    public Object getAllDetail() {
        return MOLINKS_ADDRESS_LIST;
    }

    /**
     * 数据重载
     *
     * @param init
     * @return
     */
    @GetMapping("reloadData")
    public Object reloadMonksData(@RequestParam String init) {
        return config.reloadData();
    }

    /**
     * 取最近的商店。可以考虑加个分页
     *
     * @param coordinate lon 经度 lat 纬度
     * @return
     */
    @PostMapping("getNearbyShop")
    public Object getNearbyShop(@RequestBody Coordinate coordinate) {
        List<MolinksAddressVO> list = new ArrayList<>(2048);
        for (MolinksAddress address : MOLINKS_ADDRESS_LIST) {
            double lon1 = address.getBmapLon();
            double lat1 = address.getBmapLat();

            double distance = DistanceUtil.getDistance(coordinate.getLon(), coordinate.getLat(), lon1, lat1);
            MolinksAddressVO vo = getVoFromEntity(address, df.format(distance));
            list.add(vo);
        }

        //按照距离排序(由远到近)
        list.sort((o1, o2) -> {
            String distance1 = o1.getDistance();  //o1是从你list里面拿出来的第一个vo
            String distance2 = o2.getDistance();  //o2是从你list里面拿出来的第二个vo
            return distance2.compareTo(distance1);
        });
        //倒叙list排序
        Collections.reverse(list);
        List<MolinksAddressVO> sub = list.subList(0, 30);
        return ResponseUtil.ok(sub);
    }

    private MolinksAddressVO getVoFromEntity(MolinksAddress entity, String distiance) {
        MolinksAddressVO vo = new MolinksAddressVO();
        vo.setDistance(distiance);
        vo.setLat(entity.getBmapLat());
        vo.setLon(entity.getBmapLon());
        vo.setAddress(entity.getAddress());
        vo.setName(entity.getShopName());
        vo.setDistrict(entity.getDistrict());
        vo.setCity(entity.getCity());
        vo.setProvince(entity.getProvince());
        return vo;

    }
}
