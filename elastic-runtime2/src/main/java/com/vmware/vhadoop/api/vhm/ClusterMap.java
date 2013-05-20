package com.vmware.vhadoop.api.vhm;

import java.util.Map;
import java.util.Set;

import com.vmware.vhadoop.api.vhm.HadoopActions.HadoopClusterInfo;
import com.vmware.vhadoop.api.vhm.events.ClusterScaleCompletionEvent;
import com.vmware.vhadoop.api.vhm.events.ClusterStateChangeEvent.VMEventData;

/* Represents read-only and idempotent methods for ClusterMap
 * Everything returned by this interface should be a deep copy of the ClusterMap data
 * TODO: Check that this is correct */
public interface ClusterMap {

   public interface ExtraInfoToClusterMapper {

      /* Returns the key which indicates the scale strategy singleton to use for this cluster */
      String getStrategyKey(VMEventData vmd);
      
      /* Allows for the addition of contextual data to be added to a cluster and retrieved through ClusterMap */
      Map<String, String> parseExtraInfo(VMEventData vmd);
   }

   Set<String> listComputeVMsForClusterAndPowerState(String clusterId, boolean powerState);

   Set<String> listComputeVMsForClusterHostAndPowerState(String clusterId, String hostId, boolean powerState);

   Set<String> listComputeVMsForPowerState(boolean powerState);

   Set<String> listHostsWithComputeVMsForCluster(String clusterId);

   String getClusterIdForFolder(String clusterFolderName);

   Map<String, String> getHostIdsForVMs(Set<String> vmsToED);

   ClusterScaleCompletionEvent getLastClusterScaleCompletionEvent(String clusterId);

   Boolean checkPowerStateOfVms(Set<String> vmIds, boolean expectedPowerState);

   String[] getAllKnownClusterIds();

   HadoopClusterInfo getHadoopInfoForCluster(String clusterId);

   Set<String> getDnsNameForVMs(Set<String> vmIds);

   String getHostIdForVm(String vmId);

   String getClusterIdForVm(String vmIds);

   String getScaleStrategyKey(String clusterId);

   Integer getNumVCPUsForVm(String vm);
   
   Long getPowerOnTimeForVm(String vm);
   
   String getExtraInfo(String clusterId, String key);
}
