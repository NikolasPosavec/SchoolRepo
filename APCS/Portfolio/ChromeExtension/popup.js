document.getElementById('activateBtn').addEventListener('click', async () => {
    const [tab] = await chrome.tabs.query({ 
      active: true, 
      currentWindow: true 
    });
    
    chrome.tabs.sendMessage(tab.id, { 
      action: "processPassage" 
    });
    
    window.close();
  });