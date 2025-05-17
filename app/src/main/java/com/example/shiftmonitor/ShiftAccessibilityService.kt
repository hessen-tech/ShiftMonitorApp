class ShiftAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.source?.let { root ->
            if (root.findAccessibilityNodeInfosByText("Pick up shifts").isNotEmpty()) {
                // Perform refresh click
            }
            
            if (root.findAccessibilityNodeInfosByText("Claim shift").isNotEmpty()) {
                // Perform claim click
            }
        }
    }
}