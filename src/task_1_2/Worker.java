package task_1_2;

public class Worker {

	@FunctionalInterface
	public interface OnTaskDoneListener {
		void onDone(String result);
	}

	@FunctionalInterface
	public interface OnTaskErrorListener {
		void onError(String result);
	}

	private OnTaskDoneListener callback;
	private OnTaskErrorListener error;

	public Worker(OnTaskDoneListener callback, OnTaskErrorListener error) {
		this.callback = callback;
		this.error = error;
	}

	public void start() {
		for (int i = 0; i < 100; i++) {
			if (i == 33) {
				error.onError("Task " + i + " is failed");
			} else {
				callback.onDone("Task " + i + " is done");
			}
		}
	}
}
