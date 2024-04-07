package com.betrybe.minhaconta.business;

import com.ions.lightdealer.sdk.model.Address;
import com.ions.lightdealer.sdk.model.Client;
import com.ions.lightdealer.sdk.model.ElectronicDevice;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Energy account.
 */
public class EnergyAccount {

  Client client;

  public EnergyAccount(Client client) {
    this.client = client;
  }

  /**
   * Req. 11 – Find high consumption device per address.
   */
  public ElectronicDevice[] findHighConsumptionDevices() {
    List<ElectronicDevice> highConsumptionDevices = new ArrayList<>();
    for (Address address : client.getAddressesAsArray()) {
      ElectronicDevice[] addressDevices = address.getDevicesAsArray();
      ElectronicDevice highConsumptionDevice = null;
      double highConsumption = 0;
      for (ElectronicDevice device : addressDevices) {
        if (device.monthlyKwh() > highConsumption) {
          highConsumption = device.monthlyKwh();
          highConsumptionDevice = device;
        }
      }
      highConsumptionDevices.add(highConsumptionDevice);
    }
    return highConsumptionDevices.toArray(new ElectronicDevice[0]);
  }
}