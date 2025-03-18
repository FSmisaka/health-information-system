document.getElementById('send-button').addEventListener('click', async () => {
    const userQuestion = document.getElementById('user-question').value;
    const selectedModel = document.getElementById('model-select').value;

    if (userQuestion.trim() === '') {
        alert('请输入一个问题！');
        return;
    }

    document.getElementById('response').innerText = "正在处理，请稍候...";

    try {
        const response = await fetch(selectedModel, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: `question=${encodeURIComponent(userQuestion)}`
        });

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const data = await response.json();
        document.getElementById('response').innerText = data.choices[0].message.content;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('response').innerText = "额度不足。";
    }
});
