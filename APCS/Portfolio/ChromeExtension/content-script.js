chrome.runtime.onMessage.addListener((message) => {
  if (message.action === "processPassage") {
    processPassage();
  }
});

const processPassage = () => {
  try {
    const passage = document.querySelector('p.passage_para');
    if (!passage) return;

    // Clear existing numbers
    passage.querySelectorAll('.sentence-badge').forEach(badge => badge.remove());

    // Enhanced sentence splitting
    const text = passage.textContent;
    const sentences = text.split(/(?<!\b\w\.)(?<!\b\w\s\w\.)(?<=[.!?])\s+(?=[A-Z"“])/g);
    
    // Create numbered content
    passage.innerHTML = sentences.map((sentence, index) => 
      `<span class="sentence-badge">${index + 1}</span>${sentence.trim()}`
    ).join(' ');

  } catch (error) {
    console.error('Sentence Counter Error:', error);
  }
};

// Initial run with delay for dynamic content
setTimeout(processPassage, 1000);

// Watch for content changes
new MutationObserver(processPassage).observe(document.body, {
  childList: true,
  subtree: true
});