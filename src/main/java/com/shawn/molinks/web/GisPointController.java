package com.shawn.molinks.web;

import com.shawn.molinks.entity.MolinksAddress;
import com.shawn.molinks.service.GisPointConfig;
import com.shawn.molinks.utils.DistanceUtil;
import com.shawn.molinks.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @param lon 经度
     * @param lat 纬度
     * @return
     */
    @GetMapping("getNearbyShop")
    public Object getNearbyShop(@RequestParam double lon, @RequestParam double lat) {

        List<MolinksAddress> list = new ArrayList<>(2048);
        for (MolinksAddress address : MOLINKS_ADDRESS_LIST) {
            double lon1 = address.getBmapLon();
            double lat1 = address.getBmapLat();

            double distance = DistanceUtil.getDistance(lon, lat, lon1, lat1);
            address.setDistance(df.format(distance));
            list.add(address);
        }

        //按照距离排序(由远到近)
        list.sort((o1, o2) -> {
            String distance1 = o1.getDistance();  //o1是从你list里面拿出来的第一个name
            String distance2 = o2.getDistance();  //o2是从你list里面拿出来的第二个name
            return distance2.compareTo(distance1);
        });
        //倒叙list排序
        Collections.reverse(list);
        List<MolinksAddress> sub = list.subList(0, 30);
        return ResponseUtil.ok(sub);
    }
}
