package com.vmware.vhadoop.api.vhm;

import java.util.Set;

import com.vmware.vhadoop.api.vhm.events.ClusterScaleCompletionEvent;

/* Represents read-only and idempotent methods for ClusterMap */
public interface ClusterMap {

   Set<String> listComputeVMsForClusterAndPowerState(String clusterId, boolean powerState);
   
   Set<String> listComputeVMsForPowerState(boolean powerState);

   String getClusterIdForFolder(String clusterFolderName);

   ClusterScaleCompletionEvent getLastClusterScaleCompletionEvent(String clusterId);

   boolean checkPowerStateOfVms(Set<String> vmIds, boolean expectedPowerState);
}
